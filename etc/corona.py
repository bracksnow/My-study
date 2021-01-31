import random
print("---------------")
print("코로나 종식 게임")
print("---------------")
print("1. 백신 정보")
print("2. 감염된 국가 정보")
print("3. 게임 시작")
print("4. 게임 종료")
print("---------------")
class vaccine:
    def __init__(self, name, percent):
        self.name = name
        self.percent = percent
    def summary(self):
        return "백신 이름 : {}".format(self.name)+"\n"+"백신 치료율: {}".format(self.percent*100)
class country:
    def __init__(self, name, person,infected):
        self.name = name
        self.person = person
        self.infected = infected
    def summary(self):
        return "감염 국가 : {}".format(self.name)+"\n"+"인구수 : {}".format(self.person)+"\n"+"감염 인구수 : {}".format(self.infected)
menu = input("숫자를 입력하시오")
vc1 = vaccine("백신1", 0.25)
vc2 = vaccine("백신2", 0.5)
vc3 = vaccine("백신3", 1)
vc = [vc1, vc2, vc3]
random.shuffle(vc)
korea  = country("한국", 1500, 300)
japan = country("일본", 2000, 500)
china = country("중국", 3000, 800)
usa = country("미국", 2500, 750)
germany = country("독일", 2200, 1000)
cou = [korea, japan, china, usa, germany]
random.shuffle(cou)
while True:
    if menu == 1:
        print("11111111111111111111")
