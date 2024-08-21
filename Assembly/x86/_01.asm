section .data ; variable section

section .text ; program section
global _start ; starts the program

_start:
        MOV eax,1
        MOV ebx,1
        INT 80h ; Interrupts the program / 80h -> STATUS_EXIT
