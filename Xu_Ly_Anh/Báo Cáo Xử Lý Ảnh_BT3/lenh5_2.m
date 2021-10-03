X = imread('kids.tif');
%hi?n th? ?nh và lý?c ð? xám ban ð?u
figure
imshow(X);
figure
imhist(X);
%cân b?ng lý?c ð? sáng và show ?nh + lý?c ð?
Y = histeq(X);
figure
imshow(Y);
figure
imhist(Y);
xmin = min(min(X));
xmax = max(max(X));