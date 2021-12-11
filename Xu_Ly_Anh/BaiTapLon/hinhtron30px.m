function output = hinhtron30px(matrix)
    O = 30;
    for i= 1:60
        for j = 1:60
            if ((i-O)^2 + (j-O)^2) <= 30^2
                matrix(i,j) = 0;
            end
        end
    end
    output = matrix;
end