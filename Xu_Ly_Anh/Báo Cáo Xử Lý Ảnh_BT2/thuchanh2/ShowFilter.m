function ShowFilter(X,h)
% Show on a figure an image, its filtered version, and 
% the spectrums in linear and logarithmic scale.
C=0.0001;

Y=imfilter(X,h,'replicate'); 

[M1,M2]=size(X);
M=M1*M2;

[Mh1,Mh2]=size(h);
Mh=Mh1*Mh2;
Z_freq=mat2gray([abs((fft2(X)/M)) abs(fftshift(fft2(Y)/M)) abs(fftshift(fft2(h,M1,M2)/Mh))]);
Z_freqlog=mat2gray([10*log10(C+abs(fftshift(fft2(X)/M))) 10*log10(C+abs(fftshift(fft2(Y)/M))) 10*log10(C+abs(fftshift(fft2(h,M1,M2)/Mh)))]);

figure
imshow([X Z_freq ; Y Z_freqlog])
hold on
text(M2-110, 7,'Original image X','Color','g')
text(2*M2-110, 7,'Linear spectrum of X','Color','g')
text(3*M2-110, 7,'Linear spectrum of Y','Color','g')
text(4*M2-110, 7,'Linear spectrum of H','Color','g')

text(M2-110, 7+M1,'Filtered image Y','Color','g')
text(2*M2-110, 7+M1,'Log spectrum of X','Color','g')
text(3*M2-110, 7+M1,'Log spectrum of Y','Color','g')
text(4*M2-110, 7+M1,'Log spectrum of H','Color','g')
line([M1+0.5 M1+0.5],[1 4*M2],'Color','g')
line([2*M1+0.5 2*M1+0.5],[1 4*M2],'Color','g')
line([3*M1+0.5 3*M1+0.5],[1 4*M2],'Color','g')
line([1 4*M1],[M2+0.5 M2+0.5],'Color','g')