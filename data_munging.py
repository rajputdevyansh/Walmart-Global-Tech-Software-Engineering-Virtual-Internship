import pandas as pd
import sqlite3
conn = sqlite3.connect('database.db')
df0 = pd.read_excel('shipping_data_0.xlsx')
df1 = pd.read_excel('shipping_data_1.xlsx')
df2 = pd.read_excel('shipping_data_2.xlsx')
df0.to_sql('table0', conn, if_exists='append', index=False)
merged_df = pd.merge(df1, df2, on='shipping_id')
merged_df.to_sql('table1', conn, if_exists='append', index=False)
conn.close()