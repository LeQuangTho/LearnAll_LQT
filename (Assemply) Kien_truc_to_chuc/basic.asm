.model small
.stack 100h
.data 
    nhan db "Xin chao$"
.code 
main proc      
     ;ham ngat ah loai 1
     mov ah,1   ;nhap ki tu tu ban phim
     int 21h
     
     ;ham ngat ah loai 2   
     ;ham in ki tu
     mov ah,2
     mov dl,35h
     int 21h  
     
     ;ham ngat loai 9 in chuoi  
     mov ax,@data
     mov ds,ax
     mov ah,9
     lea dx,nhan
     int 21h
     
     mov ah,4ch
     int 21h
main endp
end main