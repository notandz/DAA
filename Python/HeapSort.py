import time
awal = time.time()

def HeapSort(val):
    for start in range((len(val)-2)//2, -1, -1):
        siftdown(val, start, len(val)-1)

    for end in range(len(val)-1, 0, -1):
        val[end], val[0] = val[0], val[end]
        siftdown(val, 0, end - 1)
    return val

def siftdown(val, start, end):
    root = start
    while True:
        child = root * 2 + 1
        if child > end: break
        if child + 1 <= end and val[child] < val[child + 1]:
            child += 1
        if val[root] < val[child]:
            val[root], val[child] = val[child], val[root]
            root = child
        else:
            break
        
words = []
infile = open("nanda_wordlist.txt","r")
for line in infile:
    temp = line.split()
    for i in temp:
      words.append(i)
infile.close()

HeapSort(words)
outfile = open("HeapSort_PY.txt", "w")
for i in words:
    outfile.writelines(i)
    outfile.writelines(" ")
outfile.close()

print("Running Time : %s detik" % (time.time() - awal))
