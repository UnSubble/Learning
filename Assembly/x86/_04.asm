section .data
    char DB 'A'
    list DB 1,2,3,4
    string DB "ABA",0 ; 0 aslında -> '\0'

section .text
global _start

_start:
    MOV bl,[char]
    MOV cl,[list]
    MOV eax,1
    INT 80h