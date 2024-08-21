section .data
    string DB 'Hello, World!', 0x0A

section .text
global _start

_start:
    MOV eax,4 ; write sistem çağrısının numarasıdır
    MOV ebx,1 ; stdout yapılacağını belirtir
    MOV ecx,string ; yazılacak verinin adresi
    MOV edx,13 ; veri uzunluğu
    INT 80h ; h -> hexadecimal için
    
    MOV eax,1
    XOR ebx,ebx
    INT 0x80 ; 0x -> hexadecimal için