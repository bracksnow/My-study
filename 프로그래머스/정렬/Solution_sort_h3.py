def solution(citations):
    answer = 0
    citations.sort()
    for i in range(0,len(citations)):#0부터 len(citations)-1이 범위
        h = len(citations)-i
        if citations[i]>=h:
            answer = h
            break
    return answer