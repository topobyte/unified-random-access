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
import java.io.RandomAccessFile;

public class RandomAccessFileAccess implements FileAccess
{

	private RandomAccessFile file;

	public RandomAccessFileAccess(RandomAccessFile file)
	{
		this.file = file;
	}

	@Override
	public void close() throws IOException
	{
		file.close();
	}

	@Override
	public void seek(long position) throws IOException
	{
		file.seek(position);
	}

	@Override
	public long getFilePointer() throws IOException
	{
		return file.getFilePointer();
	}

	@Override
	public void readFully(byte[] buffer) throws IOException
	{
		file.readFully(buffer);
	}

	@Override
	public void readFully(byte[] buffer, int off, int len) throws IOException
	{
		file.readFully(buffer, off, len);
	}

	@Override
	public int read(byte[] buffer, int off, int len) throws IOException
	{
		return file.read(buffer, off, len);
	}

	@Override
	public int read() throws IOException
	{
		return file.read();
	}

	@Override
	public short readShort() throws IOException
	{
		return file.readShort();
	}

	@Override
	public int readInt() throws IOException
	{
		return file.readInt();
	}

	@Override
	public int readUnsignedByte() throws IOException
	{
		return file.readUnsignedByte();
	}

	@Override
	public float readFloat() throws IOException
	{
		return file.readFloat();
	}

	@Override
	public double readDouble() throws IOException
	{
		return file.readDouble();
	}

}
