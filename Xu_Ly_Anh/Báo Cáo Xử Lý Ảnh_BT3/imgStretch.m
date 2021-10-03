function output = imgStretch(input, T1,T2)
    a = input;
    [hight, wight] = size(input);
    for i = 1:hight
        for j = 1: wight
            if a(i,j) < T1
                a(i,j) = 0;
            elseif a(i,j) > T2
                a(i,j) = 255;
            elseif a(i,j)>= T1 && a(i,j)<= T2
                a(i,j) = (255/(T2-T1))*(a(i,j)-T1);
            end
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
                