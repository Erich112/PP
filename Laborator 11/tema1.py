import asyncio
import random


async def print_number(n):
    s = 0
    for i in range (0,n):
        s = s + i
    print(s)

if __name__ == "__main__":
    loop = asyncio.get_event_loop()

    loop.run_until_complete(
        asyncio.wait([
            print_number(random.randint(0,10))
            for number in range(4)
        ])
    )