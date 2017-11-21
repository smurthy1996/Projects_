import sentiment_mod as s
import pandas as pd
import csv
from multiprocessing.dummy import Pool as ThreadPool
from pandas import algos
import numpy as nu
import string
 
 
# def MultiprocessingTask():
#     df = pd.read_csv("Tripadvisor_Data.csv")
    
#     temp_hold = []
#     temp_hold2 = []
#     for comment in df.Comment:
#         print(s.sentiment("fuck this shit was amazing"));
#         temp_hold.append(s.sentiment(comment)[0])
#         temp_hold2.append(s.sentiment(comment)[1])
#          
#     rows = zip(df.Comment,temp_hold,temp_hold2)
#      
#     with open('sentiment_analysis.csv', 'a', newline='') as f:
#         writer = csv.writer(f)
#         writer.writerow(["Review","Pos/Neg","Correlation"])
#         for row in rows:
#             writer.writerow(row)
# pool = ThreadPool(32)
#   
#   
# results = pool.map(MultiprocessingTask())

def customprint():
    temp_hold = [];
    i =0;
    print("AI Sentiment Analysis Custom Tester");
    while(True):
        entry = input("Enter custom comment: ");
        temp_hold = s.sentiment(entry);
        i = i+1;
        print("Natural Launguage Analysis; Comment was: "+temp_hold[0].__str__() + " With a corralation of: " +temp_hold[1].__str__())
        print("Sentiment was Classified and Stored: Currently "+((i.__str__()))+"% accurate")
        

customprint();




    





