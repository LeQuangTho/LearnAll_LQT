
.model small   
.stack 100h
.data db
    s1 db "kem$"
    s2 db "tot$"
    s3 db "xuat sac$"
.code
    main proc
        mov ax, @data
        mov ds,ax
        
       ;nhap
       mov ah,1
       int 21h 
       
       cmp al,'8'
       jg xuatsac
       
       cmp al,'4' 
       jg tot  
       
       mov ah,9
       lea dx,s1
       int 21h
       jmp kt
       
        
xuatsac:
mov ah,9
lea dx,s3
int 21h
jmp kt

tot:
mov ah,9
lea dx,s2
int 21h
jmp kt

kt:
mov ah,4ch
int 21h

main endp
end main




