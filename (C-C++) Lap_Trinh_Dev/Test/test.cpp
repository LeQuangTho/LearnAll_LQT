#include <iostream>

int main()
{
    setlocale(LC_ALL, "");
    std::string name;
    std::getline(std::cin, name);
    if(name.length() > 30) std::cout<<"KHONG";
    else std::cout<<"CO";
    return 0;
}
