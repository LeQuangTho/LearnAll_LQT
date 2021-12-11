import uu as uuencode
import base64


def char_to_bin(char):
    txt = bin(ord(char))[2:]
    while len(txt) < 8:
        txt = '0' + txt
    print(txt)
    return txt


def string_concatenation(string):
    bin_text = ''
    for i in string:
        print(i, ' - ', ord(i), end=' - ')
        bin_text += char_to_bin(i)
    while len(bin_text) % 6 != 0:
        bin_text += '0'
    print(bin_text)
    return bin_text


def split_bin_text(bin_text):
    text2 = []
    for i in range(int(len(bin_text) / 6)):
        text2.append(int(str(bin_text[i * 6:(i + 1) * 6]), 2))
        print(str(bin_text[i * 6:(i + 1) * 6]), end=' | ')
    return text2


if __name__ == "__main__":
    uu = ['`', '!', '”', '#', '$', '%', '&', '’',
          '(', ')', '*', '+', ',', '-', '.', '/',
          '0', '1', '2', '3', '4', '5', '6', '7',
          '8', '9', ':', ';', '<', '=', '>', '?',
          '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
          'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
          'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
          'X', 'Y', 'Z', '[', '\\', ']', '^', '_']
    xx = ['+', '-', '0', '1', '2', '3', '4', '5',
          '6', '7', '8', '9', 'A', 'B', 'C', 'D',
          'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
          'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
          'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b',
          'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
          'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
          's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
    base = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
            'I', 'J', 'K', 'L', 'M', 'V', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '0', '1', '2', '3',
            '4', '5', '6', '7', '8', '9', '+', '/']
    file = open("demo.txt", 'r')
    text = str(file.read())
    print('Text:', text)
    print('Value: ')
    var = split_bin_text(string_concatenation(text))
    print('\nValue encode:', var)
    uu_code = ''
    xx_code = ''
    base_code = ''
    for i in var:
        uu_code += uu[i]
        xx_code += xx[i]
        base_code += base[i]
    num = int((6 - ((len(text) * 8) % 6)) / 2)
    if num == 3:
        num = 0
    print('Số cặp bit "00" được thêm vào:', num)
    print('Uuencoding: {}{}'.format(uu[len(text)], uu_code) + '`' * num)
    print('Xxencoding: {}{}'.format(xx[len(text)], xx_code) + '+' * num)
    print('Base64 encoding:', base_code + '=' * num)

    # Uuencoding
    uuencode.encode('demo.txt', 'demo2.txt')
    f = open("demo2.txt", 'r')
    t = f.readline()

    # Base64 encoding
    sample_string_bytes = text.encode("ascii")
    base64_bytes = base64.b64encode(sample_string_bytes)
    base64_string = base64_bytes.decode("ascii")

    print('-----------------------\nSử dụng thư viện:')
    print('Uuencoding:', f.readline(), end='')
    print("Base64 encoding:", base64_string)
