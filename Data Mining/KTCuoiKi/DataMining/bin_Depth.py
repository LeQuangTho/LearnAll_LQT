import numpy as np
import math

# from sklearn.datasets import load_iris
# from sklearn import datasets, linear_model, metrics

# # load iris data set
# dataset = load_iris()
# a = dataset.data

# Nhập dữ liệu đã được sắp xếp tăng dần
b = [13, 15, 16,
     16, 19, 20,
     20, 21, 22,
     22, 25, 25,
     25, 25, 30,
     33, 33, 35,
     35, 35, 35,
     36, 40, 45,
     46, 52, 70,
     74, 75, 76]
# # take 1st column among 4 column of data set
# for i in range(150):
#     b[i] = a[i, 1]

b = np.sort(b)  # sort the array
numberBin = 3
# create bins
bin1 = np.zeros((math.ceil(len(b) / numberBin), numberBin))
bin2 = np.zeros((math.ceil(len(b) / numberBin), numberBin))
bin3 = np.zeros((math.ceil(len(b) / numberBin), numberBin))

length = int(len(b) / numberBin) * numberBin
# -----------------------------------------------------------------
# Bin mean
for i in range(0, length, numberBin):
    k = int(i / numberBin)
    sum = 0
    for j in range(0, numberBin):
        sum += b[i + j]
    for j in range(numberBin):
        bin1[k, j] = round(sum / numberBin, 3)

if length < len(b):
    sum = 0
    for j in range(length, len(b), 1):
        sum += b[j]
    for j in range(len(b) - length):
        bin1[-1, j] = sum / (len(b) - length)

print("Bin Trung bình: \n", bin1)
# -----------------------------------------------------------------
# Bin boundaries
for i in range(0, length, numberBin):
    k = int(i / numberBin)
    for j in range(numberBin):
        if (b[i + j] - b[i]) < (b[i + numberBin - 1] - b[i + j]):
            bin2[k, j] = b[i]
        else:
            bin2[k, j] = b[i + numberBin - 1]

for j in range(len(b) - length):
    if (b[length + j] - b[length]) < (b[length + len(b) - length - 1] - b[length + j]):
        bin2[-1, j] = b[length]
    else:
        bin2[-1, j] = b[length + len(b) - length - 1]

print("Bin Biên: \n", bin2)
# -----------------------------------------------------------------
# Bin median
for i in range(0, length, numberBin):
    k = int(i / numberBin)
    if numberBin % 2:
        for j in range(numberBin):
            bin3[k, j] = b[i + int(numberBin / 2)]
    else:
        for j in range(numberBin):
            bin3[k, j] = (b[i + int(numberBin / 2)] + b[i + int(numberBin / 2 - 1)]) / 2

if length < len(b):
    if (len(b) - length) % 2:
        for j in range(len(b) - length):
            bin3[-1, j] = b[length + int((len(b) - length) / 2)]
    else:
        for j in range(len(b) - length):
            bin3[-1, j] = (b[length + int((len(b) - length) / 2)] + b[length + int((len(b) - length) / 2 - 1)]) / 2
print("Bin Trung vị: \n", bin3)
