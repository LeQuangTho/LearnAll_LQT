X = imread('kids.tif');
%hi?n th? ?nh v� l�?c �? x�m ban �?u
figure
imshow(X);
figure
imhist(X);
%c�n b?ng l�?c �? s�ng v� show ?nh + l�?c �?
Y = histeq(X);
figure
imshow(Y);
figure
imhist(Y);
xmin = min(min(X));
xmax = max(max(X));