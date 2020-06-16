#Load in the libraries
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

# Load in the data
df = pd.read_csv('out.csv')

#check the head
print (df.head())

plt.figure(figsize=(10,5))
sns.set_style("darkgrid")
sns.lineplot(data = df, 
			x=df.index,y='op',
			color='lightseagreen')

sns.lineplot(data = df, 
			x=df.index,y='ncc',
			color='orange')

sns.lineplot(data = df, 
			x=df.index,y='gcc',
			color='red')

sns.lineplot(data = df, 
			x=df.index,y='slcc',
			color='purple')

plt.legend(labels=['op', 'ncc', 'gcc', 'slcc'])
plt.ylabel('Valor')
plt.savefig('out.png')
