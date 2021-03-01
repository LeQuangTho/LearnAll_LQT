.model small
.stack  100h
.data
          s1 db 'Nhap so: $'
          s2 db 10,13,'So vua nhap: $'
          a dw 0
          b dw 0
.code
          main proc
                    mov ax,@data
                    mov ds,ax
                                       
                    mov ah,9
                    lea dx,s1
                    int 21h 
                    
                    mov bx,10
                    mov dx,0
                    
          nhaptiep: mov ah,1
                    int 21h
                    
                    cmp al,13
                    je dungnhap  
                    sub al,48
                    
                    mov ah,0
                    mov a,ax
                    mov ax,b
                    mul bx
                    add ax,a
                    mov b,ax
                    jmp nhaptiep  
                    
          dungnhap: mov ax,b
                    
                    mov ah,9
                    lea dx,s2
                    int 21h
                    
                    mov ax,b
                    mov cx,0
                    
          chiatiep: mov dx,0          
                    div bx
                    cmp ax,0
                    je inso
                    push dx
                    inc cx
                    jmp chiatiep
                    
        inso:
                    add dl,48
                    mov ah,2
                    int 21h   
                    cmp cx,0
                    je thoat
        intiep:
                    pop dx  
                    add dl,48
                    int 21h
                    loop intiep  
        thoat:            
                    mov ah,4ch
                    int 21h
                    main endp
          end main  
      