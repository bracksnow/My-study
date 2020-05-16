import heapq
def solution(scoville, K):
    heap = []
    for food in scoville:
        heapq.heappush(heap, food)
    answer = 0
    while heap[0]<K:
        if(len(heap)==1):
            return -1
        else:
            heapq.heappush(heap, heapq.heappop(heap) + (heapq.heappop(heap) * 2))
            answer+=1
    return answer