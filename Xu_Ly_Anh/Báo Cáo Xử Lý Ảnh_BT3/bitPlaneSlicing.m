function y = bitPlaneSlicing( Img )
b1 = double(bitget(Img,1));
b2 = double(bitget(Img,2));
b3 = double(bitget(Img,3));
b4 = double(bitget(Img,4));
b5 = double(bitget(Img,5));
b6 = double(bitget(Img,6));
b7 = double(bitget(Img,7));
b8 = double(bitget(Img,8));
Img_b = cat(8,b1,b2,b3,b4,b5,b6,b7,b8);
figure, 
subplot(3,3,1)
imshow(Img), title('Original Image');
subplot(3,3,2)
imshow(b1), title('Bit Plane: 1');
subplot(3,3,3)
imshow(b2), title('Bit Plane: 2');
subplot(3,3,4)
imshow(b3), title('Bit Plane: 3');
subplot(3,3,5)
imshow(b4), title('Bit Plane: 4');
subplot(3,3,6)
imshow(b5), title('Bit Plane: 5');
subplot(3,3,7)
imshow(b6), title('Bit Plane: 6');
subplot(3,3,8)
imshow(b7), title('Bit Plane: 7');
subplot(3,3,9)
imshow(b8), title('Bit Plane: 8');
y = Img_b;