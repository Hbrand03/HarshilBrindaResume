function [data, header, ts] = rdataread(filename, frames)
    % Check if the necessary arguments are provided
    if nargin < 2
        error('Not enough input arguments. Both filename and frames are required.');
    end

    % Open the file
    fid = fopen(filename, 'r');
    if fid == -1
        error('Cannot open file: %s', filename);
    end

    % Read the header information
    hinfo = fread(fid, 5, 'int32');
    if numel(hinfo) < 5
        fclose(fid);
        error('Failed to read the complete header from %s', filename);
    end

    header.id = hinfo(1);
    header.frames = hinfo(2);
    header.lines = hinfo(3);
    header.samples = hinfo(4);
    header.sampleSize = hinfo(5);

    % Ensure that we do not request more frames than available
    frames = min(frames, header.frames);
    data = zeros(frames, header.samples, header.lines);
    ts = zeros(1, frames);

    % Read the data based on the header ID
    for f = 1:frames
        ts(f) = fread(fid, 1, 'int64');
        switch header.id
            case {0, 3}  % IQ data (doubled sample size for IQ data types)
                temp_data = fread(fid, [header.samples * 2, header.lines], 'int16');
            case 1  % ENV data
                temp_data = fread(fid, [header.samples, header.lines], 'uint8');
            case 2  % RF data
                temp_data = fread(fid, [header.samples, header.lines], 'int16');
            otherwise
                error('Unknown data type ID: %d', header.id);
        end
        if numel(temp_data) ~= header.samples * header.lines
            fclose(fid);
            error('Failed to read complete data for frame %d from %s', f, filename);
        end
        data(f, :, :) = temp_data;
    end

    % Close the file
    fclose(fid);
end
