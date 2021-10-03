% 2.2.1 --------------------------------------------
A1 = ones(256,256)*75;
A1(103:153, 103:153) = 175;
imshow(A1/255);
% 2.2.2 --------------------------------------------
h1 = [1 -1];
h2 = [1 ; -1];
% a
N1 = imfilter(A1, h1, 'replicate');
figure
imshow(mat2gray(N1));
% b
N2 = imfilter(A1, h2, 'replicate');
figure
imshow(mat2gray(N2));
% 2.2.3 --------------------------------------------
h3 = [1 0 -1 ; 2 0 -2 ; 1 0 -1];
h4 = [2 1 0 ; 1 0 -1 ; 0 -1 -2];
h5 = [1 2 1 ; 0 0 0 ; -1 -2 -1];
h6 = [0 1 2 ; -1 0 1 ; -2 -1 0];
N3 = imfilter(A1, h3, 'replicate');
figure
imshow(mat2gray(N3));
N4 = imfilter(A1, h4, 'replicate');
figure
imshow(mat2gray(N4));
N5 = imfilter(A1, h5, 'replicate');
figure
imshow(mat2gray(N5));
N6 = imfilter(A1, h6, 'replicate');
figure
imshow(mat2gray(N6));
% 2.2.4 --------------------------------------------
h7 = (1/8)*[0 1 0 ; 1 -4 1 ; 0 1 0];
N7 = imfilter(A1, h7, 'replicate');
figure
imshow(mat2gray(N7));
% 2.2.5 --------------------------------------------
h8 = fspecial('log', [15 15], 1);
N8 = imfilter(A1, h8, 'replicate');
figure
imshow(mat2gray(N8));
% 2.2.6 --------------------------------------------
A2 = double(imread('cameraman.tif'));
M1 = imfilter(A2, h1, 'replicate');
figure
imshow(mat2gray(M1));
M2 = imfilter(A2, h2, 'replicate');
figure
imshow(mat2gray(M2));
M3 = imfilter(A2, h3, 'replicate');
figure
imshow(mat2gray(M3));
M4 = imfilter(A2, h4, 'replicate');
figure
imshow(mat2gray(M4));
M5 = imfilter(A2, h5, 'replicate');
figure
imshow(mat2gray(M5));
M6 = imfilter(A2, h6, 'replicate');
figure
imshow(mat2gray(M6));
M7 = imfilter(A2, h7, 'replicate');
figure
imshow(mat2gray(M7));
M8 = imfilter(A2, h8, 'replicate');
imshow(mat2gray(M8));
% 2.2.7 --------------------------------------------
ShowFilter(A1, h1);
ShowFilter(A1, h2);
ShowFilter(A1, h3);
ShowFilter(A1, h4);
ShowFilter(A1, h5);
ShowFilter(A1, h6);
ShowFilter(A1, h7);
ShowFilter(A1, h8);
