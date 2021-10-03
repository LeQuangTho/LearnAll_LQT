function im = AddPeriodicNoise(im0)
% Add periodic noise to an image im
[rows, columns] = size(im0)
rng('shuffle')
rowVector = (1 : rows)';
period = 10; % 20 rows
amplitude = 0.4 + rand*0.2; % Magnitude of the ripples.
offset = 1 - amplitude; % How much the cosine is raised above 0.
cosVector = amplitude * (1 + cos(2 * pi * rowVector / period))/2 + offset;
ripplesImage = repmat(cosVector, [1, columns]);
% Multiply the ripples by the image to get an image with periodic "noise" in it.
im = ripplesImage .* double(im0);