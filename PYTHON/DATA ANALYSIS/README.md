## Hi! This is Ferennia
I want to share my mini project on creating user retention and segmentation to know the consumers' distribution. The data set I used is dummy and consists of 13 columns. It is an example of online retail data from the e-commerce industry.

Here is the data info:

<img width="367" height="301" alt="Image" src="https://github.com/user-attachments/assets/8b9718ad-0570-4669-9953-5592e2a424c0" />

From the output, we know the data is still raw and needs to be cleaned into the form we need, where every column has the proper data type. After data processing, we can finally do the data analysis of user retention and segmentation.


### 1. User Retention
   
   <img width="425" height="371" alt="Image" src="https://github.com/user-attachments/assets/5c44fd54-c88b-4bea-8e4c-fc6bd851b363" />

User retention is an analysis of consumer behavior to determine whether they tend to return to buy a product again after the first purchase. Before getting the user retention, we need the year-month of every transaction, order count for each user, the cohort which is the minimum of year-month transaction of every user (first time purchasing), and the period number, which is the distance between first purchase period and the latest purchase period.
  
  <img width="374" height="261" alt="Image" src="https://github.com/user-attachments/assets/a2ea783b-e3f6-428e-ab3c-a07945d343e9" />

After that, we can create a pivot table to see the distribution of users across each cohort or first purchase period. The period_num indicates whether users return after the first purchase year-month (1). For instance, we can see from the output that 75 people made their first purchase in March 2023, then 18 people came back the next month, 24 the following month, and so on. 

For user retention, we need to know the percentage of total users who returned and the total number of users in the first purchasing period. So, we have to divide all numbers by the total number of users in the first period. 

<img width="124" height="293" alt="Image" src="https://github.com/user-attachments/assets/62b80c14-4573-471a-b6f6-5857c2accd67" />



<img width="527" height="266" alt="Image" src="https://github.com/user-attachments/assets/37cbe1ae-24c3-4bd0-be94-7129543ce062" />

This is the result of the user retention analysis after we divide all the numbers by the total number of users in the first purchasing period.
But we need to convert all numbers to percentages with a nice display, so we should use seaborn and matplotlib to visualize the data well.


<img width="1104" height="790" alt="Image" src="https://github.com/user-attachments/assets/71dbadbe-71d6-4667-a64e-e1fa94825560" />


The heatmap shows the percentage of users returning. The numbers to the right represent the total number of users in subsequent months. The available data represents sales from January to July 2023. It means the data for users' first purchase in January would have 7 periods of percentages, and the data for July would have only one period of percentage.
 As we see there, April 2023 and June 2023 were the nicest months, with the highest percentage of users returning a month after first purchasing, while March 2023 had the lowest percentage. This can be analyzed using features or causes that could have led to these things happening, such as campaign marketing or trends that occurred at that time.



### 2. User Segmentation
User segmentation produces segmentation of users, knowing how many users need to be prioritized and paid attention to, and can help us to know and analyze how many users are loyal and what efforts can be made to increase it.

User segmentation needs to analyze each user's RFM (Recency, Frequency, Monetary) score. So we need to calculate the days after the latest order, the order count, and the order value of every user.

<img width="624" height="364" alt="Image" src="https://github.com/user-attachments/assets/0a547cd1-70c1-4694-8007-dbce77a276a3" />

After getting those values, we finally can make a score of RFM.

<img width="952" height="377" alt="Image" src="https://github.com/user-attachments/assets/aae35166-ed0b-419d-983d-213408c25d86" />

RFM scores are used for segmentation. The rules we can follow are these.

<img width="645" height="347" alt="Image" src="https://github.com/user-attachments/assets/3b05fa63-c961-42fd-9d51-74a7265e1cef" />

<img width="852" height="230" alt="Image" src="https://github.com/user-attachments/assets/853201f1-f880-413f-9f15-88d036eb8a29" />


Here is the result. But we need to turn the table to become representable. So we have to make a pivot table with segment as the index, and day_since_last_order, recency_score, monetary_score, and total users as columns.

<img width="1041" height="369" alt="Image" src="https://github.com/user-attachments/assets/4c4f593f-f549-4cf2-83a3-0348f55053da" />

This is the final visualization of user segmentation.

<img width="703" height="381" alt="Image" src="https://github.com/user-attachments/assets/cd191b17-04a1-4d31-9f40-74bac38891b0" />
<br />
As we can see here, the table tells the descriptive of every segmentation of users. Unfortunately, Hibernating segment has 124 people or 32,6%, becoming the highest proportion of segmentation. Nevertheless, the good news is the three beneficial segments which are Champion, Loyal Customers, and Potential Loyalists, has 136 people or around 36% in total. These kinds of insights are absolutely needed in business development; analyze and think about how the chances in these areas can grow even more in the future.
