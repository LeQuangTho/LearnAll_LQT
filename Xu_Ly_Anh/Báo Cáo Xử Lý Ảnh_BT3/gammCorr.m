function output=gammCorr(input,gamma)
    a = input;
    [hight, wight] = size(input);
    for i = 1:hight
        for j = 1: wight
            a(i,j) = 255*(a(i,j)/255).^gamma;
        end
    end
    output = a;
end
%clear
%clc   
%X = imread('dark.tif');
%X = double(X);
%output = gammCorr(X,1/2.2);
%imshow(output/255);
      