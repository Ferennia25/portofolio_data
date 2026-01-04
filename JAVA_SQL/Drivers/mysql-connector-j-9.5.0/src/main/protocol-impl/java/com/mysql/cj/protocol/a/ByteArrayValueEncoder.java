/*
 * Copyright (c) 2022, 2025, Oracle and/or its affiliates.
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the GNU General Public License, version 2.0, as published by
 * the Free Software Foundation.
 *
 * This program is designed to work with certain software that is licensed under separate terms, as designated in a particular file or component or in
 * included license documentation. The authors of MySQL hereby grant you an additional permission to link the program and your derivative works with the
 * separately licensed software that they have either included with the program or referenced in the documentation.
 *
 * Without limiting anything contained in the foregoing, this file, which is part of MySQL Connector/J, is also subject to the Universal FOSS Exception,
 * version 1.0, a copy of which can be found at http://oss.oracle.com/licenses/universal-foss-exception.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License, version 2.0, for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 */

import java.nio.charset.StandardCharsets;

import BindValue;
import PropertyKey;
import PropertySet;
import RuntimeProperty;
import ExceptionInterceptor;
import Message;
import ServerSession;
import NativeConstants.StringSelfDataType;
import StringUtils;

public class ByteArrayValueEncoder extends AbstractValueEncoder {

    protected RuntimeProperty<Integer> maxByteArrayAsHex;

    @Override
    public void init(PropertySet pset, ServerSession serverSess, ExceptionInterceptor excInterceptor) {
        super.init(pset, serverSess, excInterceptor);

        this.maxByteArrayAsHex = pset.getIntegerProperty(PropertyKey.maxByteArrayAsHex);
    }

    @Override
    public byte[] getBytes(BindValue binding) {
        if (binding.escapeBytesIfNeeded()) {
            return escapeBytesIfNeeded((byte[]) binding.getValue());
        }
        return (byte[]) binding.getValue();
    }

    @Override
    public String getString(BindValue binding) {
        if (binding.escapeBytesIfNeeded() && binding.getBinaryLength() <= this.maxByteArrayAsHex.getValue()) {
            return StringUtils.toString(escapeBytesIfNeeded((byte[]) binding.getValue()), StandardCharsets.US_ASCII);
        }
        return "** BYTE ARRAY DATA **";
    }

    @Override
    public void encodeAsBinary(Message msg, BindValue binding) {
        ((NativePacketPayload) msg).writeBytes(StringSelfDataType.STRING_LENENC, (byte[]) binding.getValue());
    }

}
