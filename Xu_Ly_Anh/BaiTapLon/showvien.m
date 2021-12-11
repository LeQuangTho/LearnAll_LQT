X = double(imread('image6.jpg'));
gray = rgb2gray(X/255);

fgradient_1 = [1 -1];
fgradient_2 = [1;-1];
fsobel = fspecial('sobel');
flaplace = fspecial('laplacian',1);
flog = fspecial('log',[3 3],0.5);

gray_gradient_1 = imfilter(gray,fgradient_1,'replicate');
subplot(3,2,1)
imshow(mat2gray(gray_gradient_1))
title('Gradient 1')
gray_gradient_2 = imfilter(gray,fgradient_2,'replicate');
subplot(3,2,2)
imshow(mat2gray(gray_gradient_2))
title('Gradient 2')
gray_sobel = imfilter(gray,fsobel,'replicate');
subplot(3,2,3)
imshow(mat2gray(gray_sobel))
title('Sobel')
gray_laplace = imfilter(gray,flaplace,'replicate');
subplot(3,2,4)
imshow(mat2gray(gray_laplace))
title('Laplace')
gray_log = imfilter(gray,flog,'replicate');
subplot(3,2,5)
imshow(mat2gray(gray_log))
title('Log')