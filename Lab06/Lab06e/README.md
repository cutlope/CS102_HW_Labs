Write a recursive method that enumerates and prints all n-digit even numbers in which
each digit of the number, from its most-significant to least-significant digits, is greater than
the previous one (that is, for instance, the number 124 is ok, but the number 142 is not,
since 2 is less than 4). Make sure your program prints each number just once. For example,
if n=3 it should print 124 126 128 134 136 138 146 148 156 and so on up to 999. Hint: If
you had a method that checked whether a number meets the stated criteria or not, you could
use it to filter the candidate values you generated recursively, printing only those that meet
the criteria ~ideally the criteria checking method would also be recursive.