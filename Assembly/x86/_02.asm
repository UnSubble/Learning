section .data
    num DD 5 ; DB -> 1 byte /  DW -> 2 bytes /  DD -> 4 bytes /  DQ -> 8 bytes /  DT -> 10 bytes

section .text
global _start

_start:
    MOV eax,1
    MOV ebx,[num] ; In c: num -> num / [num] -> *num
    INT 80h