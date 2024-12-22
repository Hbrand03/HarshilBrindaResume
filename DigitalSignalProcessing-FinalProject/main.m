clear all;
close all;
clc;

%% Setup and Parameters
Fs = 15.00E6;  % Sampling frequency
% Set the path where your RF data and filter coefficients are stored
dataPath = 'C:\Users\harsh\OneDrive\Desktop\Semester 4.1\DSP\Codes\Codes\Posterior_Placenta\raw_1';

% Assuming the RF data file name - update this if your data file has a different name
dataFile = '2024-04-19t21-56-53+0000_rf.raw';  % Update this with the actual RF data file name

% Load the RF data assuming it's saved in a .mat file
load(fullfile(dataPath, dataFile), 'RF'); 

% Specify which scanline to analyze (update the index as needed)
scanLine = RF(:,100);

%% Load Filter Coefficients
% Uncomment and modify the next line if you have saved your filter coefficients to a file
% load(fullfile(dataPath, 'filter_coefficients.mat'));  % Loads SOS_Butterworth, G_Butterworth, SOS_Chebychev, G_Chebychev

%% Apply Filters
y_Butterworth = filtfilt(SOS_Butterworth, G_Butterworth, scanLine);
y_Chebychev = filtfilt(SOS_Chebychev, G_Chebychev, scanLine);

%% Power Spectral Density Comparison
figure;
hold on;
pwelch(scanLine, [], [], [], Fs, 'power');
pwelch(y_Butterworth, [], [], [], Fs, 'power');
pwelch(y_Chebychev, [], [], [], Fs, 'power');
legend('Original', 'Butterworth Filtered', 'Chebychev Filtered');
title('Power Spectral Density Comparison');
xlabel('Frequency (Hz)');
ylabel('Power/Frequency (dB/Hz)');

%% B-mode Image Visualization
% Compute the envelope and display B-mode images
Bmode_original = 20 * log10(abs(hilbert(scanLine)));
Bmode_Butterworth = 20 * log10(abs(hilbert(y_Butterworth)));
Bmode_Chebychev = 20 * log10(abs(hilbert(y_Chebychev)));

figure;
subplot(1,3,1);
imagesc(Bmode_original);
title('Original B-mode Image');
colormap(gray);
axis equal;
axis tight;

subplot(1,3,2);
imagesc(Bmode_Butterworth);
title('Butterworth Filtered B-mode Image');
colormap(gray);
axis equal;
axis tight;

subplot(1,3,3);
imagesc(Bmode_Chebychev);
title('Chebychev Filtered B-mode Image');
colormap(gray);
axis equal;
axis tight;

%% Save Results (Optional)
% save(fullfile(dataPath, 'filtered_results.mat'), 'Bmode_original', 'Bmode_Butterworth', 'Bmode_Chebychev');
