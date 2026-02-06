## Hi! This is Ferennia
I’d love to share my mini project using XGBoost as the machine learning algorithm. This project’s purpose is to calculate taxi or ojek fares based on specific features. The main reason I chose XGBoost as the algorithm is that the dataset has 10000 rows, which is quite large, and that would be helpful when using an advanced algorithm such as XGBoost. 

Here are the features I used in the dataset:

1. distance_km : distance in kilometers  
2. estimated_duration_min: duration in minutes
3. pickup_hour: hour in (0-23)
4. pickup_day: day (0: Monday .. 6: Sunday)
5. traffic_level:  traffic (0: smooth, 1: traffic jam, 2: heavy traffic jam)
6. weather_condition:  (0: sunny, 1: rain, 2: heavy rain)
7. vehicle_type: (0 = motorcycle, 1 = car, 2 = large car)
8. service_type: (0 = regular, 1 = express, 2 = premium)
9. pickup_area_type: (0 = countryside, 1 = suburbs, 2 =city)
10. demand_level: (0: low, 1: normal. 2: high)

Let’s assume the dataset is already clean, and we don’t need to normalize it so that all values are on the same scale, since we use the XGBoost algorithm, which only uses thresholds for splitting, not distances like kNN, KMeans, and so on.
XGBoost (Extreme Gradient Boosting) is a decision tree-based ensemble algorithm that builds models sequentially, where each new tree is created to correct the errors of the previous tree.

### Step 1. IMPORTING LIBRARY AND DATA
Numpy, pandas, and any other packages needed for analytical data must be imported here. We absolutely need scikit-learn to support machine learning and also the xgboost package. A warnings package is also needed for interrupting all warnings that appear while the program is running.
The dataset used is artificial and already clean, so no data preparation happened.

### Step 2. SEEING THE CORRELATION BETWEEN FEATURES AND FARE PRICE

<img width="277" height="225" alt="Image" src="https://github.com/user-attachments/assets/0b02b0a6-f32c-4da9-8c2b-0c1c3f97ab46" />

Based on the syntax in the Jupyter Notebook, we acknowledge the correlation between features and fare prices. From the results, we can see that distance and duration contribute most to the fare price, with a correlation of 0.9.

### Step 3. SPLITTING DATA TRAINING AND TESTING, ALSO CREATING HYPERPARAMETER TUNING
Using train_test_split to split the dataset into training and testing data. One-fifth of the dataset is used for testing, and the rest for training. For hyperparameter tuning, we use RandomizedSearchCV because the data is large, so we need to control the search for the best parameters through iterations. RandomizedSearchCV randomly samples several combinations, making it more efficient for large hyperparameter spaces.

<img width="852" height="44" alt="Image" src="https://github.com/user-attachments/assets/4ac5c9b3-4371-4345-82bf-1b2fb3a68da2" />

Here, we identified the best parameters for data modeling, with an error of 3185 rupiah. We could get the error from positive square root of negative MSE.

### Step 4. DATA MODELING AND METRICS EVALUATION
<img width="304" height="196" alt="Image" src="https://github.com/user-attachments/assets/3e58cef6-0bea-4ad9-875d-5b78add90843" />

After obtaining the best parameters, we use them all to model and train the data. Furthermore, we use the model on data testing to see how well the model performs. To know it, we have to see the metrics evaluation. Here are the errors rate we got:

<img width="128" height="72" alt="Image" src="https://github.com/user-attachments/assets/804144fd-6c9c-477d-86ff-bbd92e49a98a" />

### Step 5. PREDICTING RESULT OF NEW DATA USING MODEL
After all, we can use the model on the new data to predict the fare price!
<img width="271" height="197" alt="Image" src="https://github.com/user-attachments/assets/759b8ed4-4009-42a4-bc0a-a121a790084b" />




