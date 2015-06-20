// Copyright 2015 Sebastian Kuerten
//
// This file is part of unified-random-access.
//
// unified-random-access is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// unified-random-access is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with unified-random-access. If not, see <http://www.gnu.org/licenses/>.

package de.topobyte.randomaccess;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamFileAccess implements FileAccess
{

	private InputStream input;

	public InputStreamFileAccess(InputStream input)
	{
		this.input = input;
	}

	@Override
	public void close() throws IOException
	{
		input.close();
	}

	private long filePointer = 0;

	@Override
	public void seek(long position) throws IOException
	{
		while (filePointer != position) {
			if (filePointer < position) {
				long diff = position - filePointer;
				filePointer += input.skip(diff);
			} else {
				input.reset();
				filePointer = 0;
			}
		}
	}

	@Override
	public long getFilePointer() throws IOException
	{
		return filePointer;
	}

	@Override
	public void readFully(byte[] buffer) throws IOException
	{
		int done = 0;
		int todo = buffer.length;
		while (todo > 0) {
			int got = input.read(buffer, done, todo);
			done += got;
			todo -= got;
		}
		filePointer += buffer.length;
	}

	@Override
	public void readFully(byte[] buffer, int off, int length)
			throws IOException
	{
		int done = 0;
		int todo = length;
		while (todo > 0) {
			int got = input.read(buffer, off + done, todo);
			done += got;
			todo -= got;
		}
		filePointer += buffer.length;
	}

	@Override
	public int read(byte[] buffer, int start, int length) throws IOException
	{
		int r = input.read(buffer, start, length);
		filePointer += r;
		return r;
	}

	@Override
	public int read() throws IOException
	{
		filePointer += 1;
		return input.read();
	}

	@Override
	public short readShort() throws IOException
	{
		filePointer += 2;
		int ch1 = input.read();
		int ch2 = input.read();
		return (short) ((ch1 << 8) + (ch2 << 0));
	}

	@Override
	public int readInt() throws IOException
	{
		filePointer += 4;
		int ch1 = input.read();
		int ch2 = input.read();
		int ch3 = input.read();
		int ch4 = input.read();
		return ((ch1 << 24) + (ch2 << 16) + (ch3 << 8) + (ch4 << 0));
	}

	@Override
	public int readUnsignedByte() throws IOException
	{
		filePointer += 1;
		int ch = input.read();
		return ch;
	}

	@Override
	public float readFloat() throws IOException
	{
		return Float.intBitsToFloat(readInt());
	}

	@Override
	public double readDouble() throws IOException
	{
		return Double.longBitsToDouble(readLong());
	}

	public final long readLong() throws IOException
	{
		return ((long) (readInt()) << 32) + (readInt() & 0xFFFFFFFFL);
	}

}
