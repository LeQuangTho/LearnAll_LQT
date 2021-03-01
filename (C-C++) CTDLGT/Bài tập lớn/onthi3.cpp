#include <bits/stdc++.h>
#include <string>
#include "SLITR.cpp"
using namespace std;
class Employee
{
private:
	string ID, name, sex;
	int year;
	double salary;

public:
	friend istream &operator>>(istream &is, Employee &e)
	{
		cout << "\nEnter ID of Employee: ";
		getline(is, e.ID);
		cout << "\nEnter Name of Employee: ";
		getline(is, e.name);
		cout << "\nEnter Sex of Employee: ";
		getline(is, e.sex);
		cout << "\nEnter year: ";
		is >> e.year;
		cout << "\nEnter salary : ";
		is >> e.salary;
		fflush(stdin);
		return is;
	}
	friend ostream &operator<<(ostream &os, Employee &e)
	{
		os << "\nID of Employee: " << e.ID;
		os << "\nName of Employee: " << e.name;
		os << "\nSex of Employee: " << e.sex;
		os << "\nYear of Employee: " << e.year;
		os << "\nSalary of Employee: " << e.salary;
		return os;
	}
	string getID()
	{
		return ID;
	}
	double getSalary()
	{
		return salary;
	}
};
class Manage_List_Employee
{
private:
	int n;
	singleList<Employee> s;

public:
	void input_List()
	{
		cout << "\nEnter the number of employee: ";
		cin >> n;
		fflush(stdin);
		for (int i = 0; i < n; i++)
		{
			cout << "\nEnter information of the " << i + 1 << "th Employee: ";
			Employee p;
			cin >> p;
			s.insertLast(p);
		}
	}
	void output_List()
	{
		singleListItr<Employee> itr(&s);
		while (itr.hasNext())
		{
			Employee p = itr.next();
			cout << p;
			cout << "\n_________________________________";
		}
	}
	void remove_Employee(string ID)
	{
		int k = 0;
		singleListItr<Employee> itr(&s);
		while (itr.hasNext())
		{
			Employee p = itr.next();
			if (p.getID() != ID)
				k++;
			else
				s.remove(s.getNode(k));
		}
	}
	void output_Follow_Salary()
	{
		singleListItr<Employee> itr(&s);
		while (itr.hasNext())
		{
			Employee p = itr.next();
			if (p.getSalary() > 2000000)
				cout << p;
		}
	}
};
int main()
{
	Manage_List_Employee l;
	l.input_List();
	string x;
	cout << "\nEnter ID of Employee to remove: ";
	getline(cin, x);
	l.remove_Employee(x);
	l.output_List();
	cout << "\nList Follow Salary: ";
	l.output_Follow_Salary();
}
