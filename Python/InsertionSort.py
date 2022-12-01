import time
awal = time.time()

def InsertionSort(val):
    for isi in range(len(val)-1,0,-1):
        Max=0
        for lokasi in range(1,isi+1):
            if val[lokasi]>val[Max]:
                Max = lokasi

        temp = val[isi]
        val[isi] = val[Max]
        val[Max] = temp
        
def descending(data):
    for i in range(len(data)):
        for j in range(len(data)):
            if(data[i] > data[j]):
                temp = data[i]
                data[i] = data[j]
                data[j] = temp

words = []
infile = open("nanda_wordlist.txt","r")
for line in infile:
    temp = line.split()
    for i in temp:
      words.append(i)
infile.close()

InsertionSort(words)
outfile = open("InsertionSort_PY.txt", "w")
for i in words:
    outfile.writelines(i)
    outfile.writelines(" ")
outfile.close()

print("Running Time : %s detik" % (time.time() - awal))