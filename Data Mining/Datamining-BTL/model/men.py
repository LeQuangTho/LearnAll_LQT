class Men:
    def __init__(self, season,
                 age,
                 childish,
                 accident,
                 surgical,
                 high_fevers,
                 frequency,
                 smoking,
                 number_of_hours,
                 output):
        self.season = season
        self.age = age
        self.childish = childish
        self.accident = accident
        self.surgical = surgical
        self.high_fevers = high_fevers
        self.frequency = frequency
        self.smoking = smoking
        self.number_of_hours = number_of_hours
        self.output = output

    def __str__(self):
        return ([self.season,
                 self.age,
                 self.childish,
                 self.accident,
                 self.surgical,
                 self.high_fevers,
                 self.frequency,
                 self.smoking,
                 self.number_of_hours,
                 self.output])

    def get_properties(self, index):
        if index == 0:
            return self.season
        elif index == 1:
            return self.age
        elif index == 2:
            return self.childish
        elif index == 3:
            return self.accident
        elif index == 4:
            return self.surgical
        elif index == 5:
            return self.high_fevers
        elif index == 6:
            return self.frequency
        elif index == 7:
            return self.smoking
        elif index == 8:
            return self.number_of_hours
        elif index == 9:
            return self.output
