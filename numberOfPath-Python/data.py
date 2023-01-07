class info:
    def __int__(self):
        self.rows = 0
        self.cols = 0
        self.cost = 0
        self.path = 0
        self.time = ""

    def get_rows(self):
        return self.rows

    def get_cols(self):
        return self.cols

    def get_cost(self):
        return self.cost

    def get_path(self):
        return self.path

    def get_time(self):
        return self.time

    def set_rows(self,value):
        self.rows = value

    def set_cols(self,value):
        self.cols = value

    def set_cost(self,value):
        self.cost = value

    def set_path(self,value):
        self.path = value

    def set_time(self, value):
        self.time = value

