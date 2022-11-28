
def fib(n):
    mem = {}

    def mem_fib(n):
        key = n
        if key not in mem:
            if n < 2:
                res = n
            else:
                res = fib(n-1) + fib(n - 2)
            mem[key] = res
        return mem[key]

    return mem_fib(n)


print(fib(6))
