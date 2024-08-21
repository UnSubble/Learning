section .data 
    num DB 1
    num2 DB 2

section .text
global _start

_start:
    ; MOV ebx,[num] ; [num] -> 1 byte ama ebx 32 bit alıyor. Yani sonraki adresleri de aldığından value'umuz saçma bir değer çıkıyor.
    MOV bl,[num] ; -> ebx ile bl aynı yer ve aynı value'yu tutuyor. Ama bl için 8 bit gerektiğinden sonraki adresleri alımıyor.
    MOV cl,[num2]
    MOV eax,1
    INT 80h 

; eax ebx -> 32 bit
; ax bx -> 16 bit
; al ah bl bh -> 8 bit