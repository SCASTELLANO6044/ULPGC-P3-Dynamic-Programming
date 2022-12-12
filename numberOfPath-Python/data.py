class Data(object):
    __rows = 0
    __cols = 0
    __cost = 0
    __path = 0
    __time = ""

    @staticmethod
    def getRows():
        return Data.__rows

    @staticmethod
    def getCols():
        return Data.__cols

    @staticmethod
    def getCost():
        return Data.__cost

    @staticmethod
    def getPath():
        return Data.__path

    @staticmethod
    def getTime():
        return Data.__time

    @staticmethod
    def setRows(rows):
        Data.__rows = rows

    @staticmethod
    def setCols(cols):
        Data.__cols = cols

    @staticmethod
    def setCost(cost):
        Data.__cost = cost

    @staticmethod
    def setPath(paths):
        Data.__path = paths

    @staticmethod
    def setTime(time):
        Data.__time = time
