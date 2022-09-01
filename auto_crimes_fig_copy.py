## Justin Taylor
from os import read
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import statsmodels.api as sm

def read_autos(file):
    df = pd.read_csv(file,header=0,index_col=0,usecols=['State','Year','Data.Rates.Property.Motor'])
    return df

def get_subset(df):
    sub = df.loc['Arizona','Data.Rates.Property.Motor']
    sub.index = range(1960,2020)
    return sub

def make_fig(df):
    ax = df.plot.line(color='green')
    ax.set_ylabel('Number of Crimes', fontsize=18, color='purple')
    ax.set_title('Arizona Auto Theft Numbers (1960 - 2019)', fontsize=18, color='purple')

def main(): 
    df = read_autos('state_crime.csv')
    sub = get_subset(df)
    make_fig(sub)
    plt.show()
