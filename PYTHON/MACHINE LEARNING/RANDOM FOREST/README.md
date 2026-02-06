## Hi! This is Ferennia

I’m very excited to share what I have learnt about Random Forest and applied the algorithm to my mini project. This project’s purpose is to calculate taxi or ojek fares based on specific features. The main reason I used Random Forest as the algorithm is that the dataset has 1000 rows, which is not particularly large, and it is easier to predict with Random Forest. 

Here are the features I used in the dataset:
1. km: distance in kilometers  
2. waktu_menit: duration in minutes
3. lokasi: destination location  (1 = city, 2 = suburbs, 3 = countryside)
4. jenis_kendaraan: vehicle (1 = motorcycle, 2 = small car, 3 = large car)
5. macet: traffic (1-5)

Let’s assume the dataset is already clean, and we don’t need to normalize it so that all values are on the same scale, since we use the Random Forest algorithm, which only uses thresholds for splitting, not distances like kNN, KMeans, and so on.

Random Forest builds multiple decision trees, each trained using bootstrap sampling data, and at each node, only a random subset of features is considered for splitting. Consequently, each tree has a different structure, features, and threshold. When new data arrives, each tree generates its own prediction. For regression, the final prediction is obtained by averaging the predictions from all trees, while for classification, majority voting or average probability is used.

### Step 1. IMPORTING LIBRARY AND DATA
Numpy, pandas, and any other packages needed for analytical data must be imported here. We absolutely need scikit-learn to support machine learning. A warnings package is also needed for interrupting all warnings that appear while the program is running.
The dataset used is artificial and already clean, so no data preparation happened.

### Step 2. SEEING THE CORRELATION BETWEEN FEATURES AND FARE PRICE

<img width="256" height="140" alt="Image" src="https://github.com/user-attachments/assets/bec1e654-d0e5-43cf-81a7-083be89eecc5" />

Based on the syntax in the Jupyter Notebook, we acknowledge the correlation between features and fare prices. From the results, we can see that distance and duration contribute most to the fare price, with a correlation of 0.8.

### Step 3. SPLITTING DATA TRAINING AND TESTING, ALSO CREATING HYPERPARAMETER TUNING
Using train_test_split to split the dataset into training and testing data. One-fifth of the dataset is used for testing, and the rest for training. For hyperparameter tuning, we use GridSearchCV because the data is not large, so evaluating all combinations would not take too long.

<img width="749" height="61" alt="Image" src="https://github.com/user-attachments/assets/5e47886b-c440-4e2a-85a5-cea03831a7f8" />

Here, we identified the best parameters for data modeling, with an error of around 4590 rupiah. We could get the error from positive square root of negative MSE.

### Step 4. DATA MODELING AND METRICS EVALUATION

<img width="342" height="196" alt="Image" src="https://github.com/user-attachments/assets/c5612e97-0f13-4c5f-af08-049cacca51fa" />

After obtaining the best parameters, we use them all to model and train the data. Since we use Bootstrap, we definitely have data that is not included in the trees, which means we’re gonna have OOB score, which can be our free validation score.

<img width="141" height="34" alt="Image" src="https://github.com/user-attachments/assets/94d3f2eb-1f59-48a8-bd50-b0de179203c2" />

Furthermore, we use the model on data testing to see how well the model performs. To know it, we have to see the metrics evaluation. Here are the errors rate we got:

<img width="142" height="96" alt="Image" src="https://github.com/user-attachments/assets/c7cf7606-d80f-48ff-830a-b69596d16159" />

### Step 5. PREDICTING RESULT OF NEW DATA USING MODEL
After all, we can use the model on the new data to predict the fare price!

<img width="148" height="109" alt="Image" src="https://github.com/user-attachments/assets/32ecded5-b89c-46a8-bb98-c66954ecceb2" />


