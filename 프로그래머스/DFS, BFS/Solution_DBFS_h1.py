answer = 0
def solution(numbers, target):

    def DFS(numbers, target, index=0):
        global answer #answer은 전역변수임
        if index==len(numbers):
            sum = 0
            for number in numbers:
                sum+=number
            if sum==target:
                answer+=1
        else:
            numbers[index]*=1
            DFS(numbers,target,index+1)
            numbers[index]*=-1
            DFS(numbers,target,index+1)

    DFS(numbers,target)

    return answer



    
    