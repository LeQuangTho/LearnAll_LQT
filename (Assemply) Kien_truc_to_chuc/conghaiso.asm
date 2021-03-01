.model small
.stack 100h
.data
s1 db 'Nhap so thu 1: $'
s2 db 10,13,'Nhap so thu 2: $'
s3 db 10,13,'ket qua la: $'
a dw 0
b dw 0
c dw 0
.code
main proc
    mov ax,@data
    mov ds,ax 
    
    mov bx,10
    
    mov ah,9
    lea dx,s1
    int 21h
nhaptiep:    
    mov ah,1
    int 21h
    
    cmp al,13
    je nhapso2
    
    sub al,48
    
    mov ah,0
    mov a,ax
    mov ax,b
    mul bx
    add ax,a
    mov b,ax
    jmp nhaptiep
nhapso2:
   mov ah,9
   lea dx,s2
   int 21h
nhaptiep2:   
   mov ah,1
   int 21h
   
   cmp al,13
   je dungnhap
   
   sub al,48
   
   mov ah,0
   mov a,ax
   mov ax,c
   mul bx
   add ax,a
   mov c,ax
   jmp nhaptiep2
dungnhap:
   mov ah,9
   lea dx,s3
   int 21h
   
   mov ax,0
   add ax,b
   add ax,c
   
   mov cx,0
chiatiep:
   mov dx,0
   div bx
   
   cmp ax,0
   je inra
   
   push dx
   inc cx
   jmp chiatiep
inra:
   add dl,48
   mov ah,2
   int 21h
   
   cmp cx,0
   je stopHere
intiep:   
   pop dx
   add dl,48
   int 21h
   loop intiep
   
stopHere:
   mov ah,4ch
   int 21h
   main endp
end main