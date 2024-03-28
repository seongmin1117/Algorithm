a, b = input().split()  # 두 수 입력받기
if len(a) != 3 or len(b) != 3:
    print("세 자리 수를 입력하세요.")
else:
    a = int(a[::-1])  # a를 뒤집어서 정수로 변환하기
    b = int(b[::-1])  # b를 뒤집어서 정수로 변환하기

    if a > b:
        print(a)
    else:
        print(b)