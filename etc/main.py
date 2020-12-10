import random


def print_menu():
    print("---------------")
    print("코로나 종식 게임")
    print("---------------")
    print("1. 백신 정보")
    print("2. 감염된 국가 정보")
    print("3. 게임 시작")
    print("4. 게임 종료")
    print("---------------")


def print_vc():
    for i in range(0, len(vaccines)):
        print(vaccines[i].summary())


def print_menu_vc():
    print(vc1.summary())
    print(vc2.summary())
    print(vc3.summary())


def print_cou():
    for i in range(0, len(countries)):
        print(countries[i].summary())


def print_menu_cou():
    print(korea.summary())
    print(japan.summary())
    print(china.summary())
    print(usa.summary())
    print(germany.summary())


def final_result():
    print("================================")
    print("최종 결과")
    print("================================")
    print("라운드마다 추가로 감염된 감염자 수: " + str(int(roundTotalInfected)))
    print("백신으로 치료된 감염자 수: " + str(int(roundTotalcured)))
    if int(len(curedcountries)) != 0:
        print("백신으로 완치된 국가: ")
        for i in range(0, int(len(curedcountries))):
            print(curedcountries[i].name, end=" ")
            print("({})".format(len(curedcountries)))
            print("")
        for lank in range(0, len(finalcountries)):
            print("{} 순위".format(lank+1))
            print(finalcountries[lank].summary())
    else:
        print("백신으로 완치된 국가: 없음")
        for lank in range(0, len(finalcountries)):
            print("{} 순위".format(lank+1))
            print(finalcountries[lank].summary())


class Vaccine:
    def __init__(self, name, percent):
        self.name = name
        self.percent = percent

    def summary(self):
        return "백신 이름 : {}".format(self.name) + "\n" + "백신 치료율: {}%".format(self.percent * 100)


class Country:
    def __init__(self, name, person, infected, check):

        self.name = name
        self.person = person
        self.infected = infected
        self.check = check

    def summary(self):
        return "감염 국가 : {}".format(self.name) + "\n" + "인구수 : {}명".format(self.person) + "\n" + "감염 인구수 : {}명".format(
            int(self.infected)) + "\n"

    def checkFinshed(self):
        if self.infected >= self.person:
            self.check = True
        else:
            self.check = False
        return self.check

    def infecteeincrease(self):
        self.infected += int(self.person) * 0.15


print_menu()
menu = input("")
vc1 = Vaccine("백신1", 0.25)
vc2 = Vaccine("백신2", 0.5)
vc3 = Vaccine("백신3", 1)
vaccines = [vc1, vc2, vc3]
korea = Country("한국", 1500, 300, False)
japan = Country("일본", 2000, 500, False)
china = Country("중국", 3000, 800, False)
usa = Country("미국", 2500, 750, False)
germany = Country("독일", 2200, 1000, False)
countries = [korea, japan, china, usa, germany]
curedcountries = []
finalcountries = []
roundTotalInfected = 0
roundTotalcured = 0
while True:
    if int(menu) == 1:
        print_menu_vc()
        print_menu()
        menu = input()
    elif int(menu) == 2:
        print_menu_cou()
        print_menu()
        menu = input()
    elif int(menu) == 3:
        print("사용할 백신(1~3)과 백신을 적용할 국가(1~5)의 번호를 입력하시오")
        useVaccine = input()
        useCountry = input()
        print("* 1 차 시도 *")
        print("선택된 백신: {}, 치료율: {}%".format(vaccines[int(useVaccine) - 1].name,
                                            vaccines[int(useVaccine) - 1].percent * 100))
        print("선택된 나라: " + countries[int(useCountry) - 1].name + ", 인구수: {}".format(
            countries[int(useCountry) - 1].person) + ", 감염자수: {}명".format(countries[int(useCountry) - 1].infected))
        print("================================")
        roundTotalcured += countries[int(useCountry) - 1].infected * vaccines[int(useVaccine) - 1].percent
        countries[int(useCountry) - 1].infected -= countries[int(useCountry) - 1].infected * vaccines[
            int(useVaccine) - 1].percent
        if int(countries[int(useCountry) - 1].infected) <= 0:
            print("완치된 국가: " + countries[int(useCountry) - 1].name)
            curedcountries.append(countries[int(useCountry) - 1])
            countries.pop(int(useCountry) - 1)
            print("1차 백신 투여 후 감염된 나라에 대한 정보")
            print("================================")
            print_cou()
            for i in range(0, len(countries)):
                roundTotalInfected += int(countries[i].person) * 0.15
                countries[i].infecteeincrease()
                # 처음에는 무조건 15% 늘어도 감염자수가 인구수보다 많을 수 없음

        else:
            print("1차 백신 투여 후 감염된 나라에 대한 정보")
            print("================================")
            print_cou()
            for i in range(0, len(countries)):
                roundTotalInfected += int(countries[i].person) * 0.15
                countries[i].infecteeincrease()
                # 처음에는 무조건 15% 늘어도 감염자수가 인구수보다 많을 수 없음
        for num in range(2, 6):
            if int(num) == 5:
                print("* {} 차 시도 *".format(num))
                random.shuffle(vaccines)
                random.shuffle(countries)
                chosecountry = random.choice(countries)
                chosevaccine = random.choice(vaccines)
                print("선택된 백신: {}, 치료율: {}%".format(chosevaccine.name,
                                                    chosevaccine.percent * 100))
                print("선택된 나라: " + chosecountry.name + ", 인구수: {}".format(
                    chosecountry.person) + ", 감염자수: {}명".format(int(chosecountry.infected)))
                print("================================")
                roundTotalcured += chosecountry.infected * chosevaccine.percent
                chosecountry.infected -= chosecountry.infected * chosevaccine.percent
                print("{}차 백신 투여 후 감염된 나라에 대한 정보".format(num))
                print("================================")
                if int(len(curedcountries)) == 5:
                    print("모든 국가가 완치되었습니다.")
                    print("================================")
                print_cou()
                finalcountries = list(curedcountries)
                finalcountries.extend(countries)
                finalcountries.sort(key=lambda s: s.infected)
                final_result()

            else:
                print("* {} 차 시도 *".format(num))
                random.shuffle(vaccines)
                random.shuffle(countries)
                chosecountry = random.choice(countries)
                chosevaccine = random.choice(vaccines)
                print("선택된 백신: {}, 치료율: {}%".format(chosevaccine.name,
                                                    chosevaccine.percent * 100))
                print("선택된 나라: " + chosecountry.name + ", 인구수: {}".format(
                    chosecountry.person) + ", 감염자수: {}명".format(int(chosecountry.infected)))
                print("================================")
                roundTotalcured += chosecountry.infected * chosevaccine.percent
                chosecountry.infected -= chosecountry.infected * chosevaccine.percent
                if chosecountry.infected <= 0:
                    print("완치된 국가: " + chosecountry.name)
                    curedcountries.append(chosecountry)
                    countries.pop(countries.index(chosecountry))
                    print("{}차 백신 투여 후 감염된 나라에 대한 정보".format(num))
                    print("================================")
                    print_cou()
                    for i in range(0, len(countries)):
                        roundTotalInfected += int(countries[i].person) * 0.15
                        countries[i].infecteeincrease()
                        if countries[i].checkFinshed():
                            print("감염자의 수가 인구 수보다 많은 국가가 발생하였습니다. 게임을 중단합니다!!")
                            finalcountries = list(curedcountries)
                            finalcountries.extend(countries)
                            finalcountries.sort(key=lambda s: s.infected)
                            final_result()
                            exit()
                else:
                    print("{}차 백신 투여 후 감염된 나라에 대한 정보".format(num))
                    print("================================")
                    print_cou()
                    for i in range(0, len(countries)):
                        roundTotalInfected += int(countries[i].person) * 0.15
                        countries[i].infecteeincrease()
                        if countries[i].checkFinshed():
                            print("감염자의 수가 인구 수보다 많은 국가가 발생하였습니다. 게임을 중단합니다!!")
                            finalcountries = list(curedcountries)
                            finalcountries.extend(countries)
                            finalcountries.sort(key=lambda s: s.infected)
                            final_result()
                            exit()

    elif int(menu) == 4:
        print("게임을 종료하겠습니다.")
        exit()
    else:
        print("메뉴를 다시 확인하세요")
        print_menu()
        menu = input()
