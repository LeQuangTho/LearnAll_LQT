import uu as uuencode
import base64

bin_len = 8


def char_to_bin(char):
    txt = bin(ord2(char))[2:]
    while len(txt) < 6:
        txt = '0' + txt
    print(txt)
    return txt


def ord2(ch):

    for i in range(len(base)):# TODO
        # TODO
        if base[i] == ch:
            return i


def string_concatenation(string):
    bin_text = ''
    for i in string:
        print(i, ' - ', ord2(i), end=' - ')
        bin_text += char_to_bin(i)
    while len(bin_text) % bin_len != 0:
        bin_text += '0'
    print(bin_text)
    return bin_text


def split_bin_text(bin_text):
    text2 = []
    for i in range(int(len(bin_text) / bin_len)):
        text2.append(int(str(bin_text[i * bin_len:(i + 1) * bin_len]), 2))
        print(str(bin_text[i * bin_len:(i + 1) * bin_len]), end=' | ')
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
            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '0', '1', '2', '3',
            '4', '5', '6', '7', '8', '9', '+', '/']
    # file = open("demo.txt", 'r')
    # text = str(file.read())
    # TODO
    text = "TienVanP"
    print('Text:', text)
    print('Value: ')
    var = split_bin_text(string_concatenation(text))
    print('\nValue encode:', var)
    for i in var:
        print(chr(i), end="")
