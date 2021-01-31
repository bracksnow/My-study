class Knight:
    def __init__(self, health, mana, armor):
        self.health = health
        self.mana = mana
        self.armor = armor

    def slash(self):
        print("베게")

i = Knight(health=542.4, mana=210.3, armor=38)
print(i.health, i.mana, i.armor)
i.slash()