# Linux Commands

## Top Commands

__`ln [TARGET_PATH] [LINK_PATH]` ->__ Create symbolic links (shortcuts) to other files.

__`unzip [TARGET_PATH]` ->__ Unzip files.

__`ssh` ->__ Secure shell.

__`wget [LINK]` ->__ Direct download files from the internet.

__`alias [VAR_NAME]=[CMD]` ->__ komut için kısa isimde değişken atayabiliriz.

__`rev [FILE_PATH]` ->__ dosya içeriğini ters olarak bastırır.

__`xargs [CMD]` ->__ stdin'den girdi kabul etmeyen araçlara(`[CMD]`) girdi gönderebilmek için kullanılır.

- example for `chmod`:
	The permission mask is a three-digit octal number, where each digit represents the permissions for a level (owner, group, others). Each digit is calculated by adding the values of the relevant permissions:
	- 4: Read
	- 2: Write
	- 1: Execute
	For example, 755 represents:
	- Owner: Read, Write, Execute (4 + 2 + 1)
	- Group: Read, Execute (4 + 1)
	- Others: Read, Execute (4 + 1)

__`chown [USERNAME] [FILE_PATH]` ->__ Changes owner of file.

__`du [TARGET_PATH]` ->__ Shows disk usages per file in the target path.

__`wc [FILE_PATH]` ->__ Prints the number of line/word/character of the target file according to the entered option.

__`sed -i 's/OLD_WORD/NEW_WORD/g' [FILE_PATH]` ->__ Replaces the new word with all the old word of the target file.

__`tr old_chars new_chars [INPUT]` ->__ eski karakterleri yenileri ile değiştirir. 


## File Management

__`less [FILE_PATH]` ->__ When you want to view a file that is longer than one screen, you can use either the `less` utility or the more utility.

__`head -n [COUNT] [FILE_PATH]` ->__ By default the `head` utility displays the first 10 lines of a file.

__`tail -n [COUNT] [FILE_PATH]` ->__ By default `tail` will show the last 10 lines of the file.

__`tail -f [FILE_PATH]` ->__ To continuously monitor the incoming log messages into `FILE_PATH` file in runtime.

__`find [PATH] [OPTIONS] [FILE_NAME]` ->__ `find` command will search for file or directory based on the OPTIONS provided.

__`which [COMMAND_NAME]` ->__`which` will print the full path of the provided `PROGRAMNAME` on `STDOUT`  It does this by searching for an executable or script in the directories listed in the environment variable `PATH`. (example: `which ls` -> output: /usr/bin/ls)

__`tee [TARGET_PATH]` ->__ pipe(`|)` yerine (`T`) şeklinde çalışır. Yani hem `TARGET_PATH`'e hem de devamında gelecek olan komuta girdileri iletir. Örn:

![[Screenshot from 2024-10-15 19-34-33.png]]

<hr>

## Check User Information

__`who -u` ->__ The `who` utility displays a list of users who are logged in on the local system.


## Check System Information

__`uptime` ->__ The `uptime` utility displays a single line that includes the time of day, the period of time the computer has been running (in days, hours, and minutes), the number of users logged in, and the load average (how busy the system is).


# Keybindings

__`ALT + A` ->__ terminalde bulunduğumuz satırda en başa yönlendirir.

__`ALT + E` ->__ terminalde bulunduğumuz satırda en sona yönlendirir.

__`ALT + B` ->__ terminalde bulunduğumuz satırda bir kelime geri gider.

__`ALT + F` ->__ terminalde bulunduğumuz satırda bir kelime ileri gider.

__`CTRL + XX` ->__ terminalde bulunduğumuz satırda en başa yönlendirir, tekrar basarsak önceki konuma yönlendirir.

__`ALT + BACKSPACE` ->__ terminalde bulunduğumuz satırda bir kelimeyi siler.

__`ALT + D` ->__ terminalde bulunduğumuz satırda imlecin sağındaki kelimeyi siler.

__`CTRL + W` ->__ terminalde bulunduğumuz satırda imlecin durduğu kelimeyi keser.

__`CTRL + Y` ->__ terminalde bulunduğumuz satırda imlecin durduğu yere kesilen kelimeyi yapıştırır.


# Linux File Hierarchy

__`/bin` ->__ binary/çalıştırılabilir dosyaları tutar.

__`/sbin` ->__ system binaries.

__`/boot` ->__ sistem başlangıcı config dosyalarının olduğu yer.

__`/dev` ->__ sisteme bağlı olan tüm aygıtları dosya gibi tutulduğu yer.

__`/etc` ->__ sistemle ilgili config dosyalarının olduğu yer.

__`/home` ->__ kullanıcıların kişisel dosyalarının barındırıldığı yer.

__`/mnt` ->__ disk aygıtlarının tutulduğu bölüm.

__`/lib` ->__ sistemdeki araçların ortak kütüphanelerini barındırır.

__`/tmp` ->__ geçici dosyaların tutulduğu dizin.

__`/media` ->__ çıkartılabilir medya aygıtlarının tutulduğu bölüm.

__`/opt` ->__ sisteme yüklenen harici uygulamalar kendi kütüphanelerini veya config dosyalarını bu dizinde tutabiliyor.

__`/proc` ->__ şu anki process'leri dosya şeklinde gösterir.

__`/root` ->__ root kullanıcısının ev dizini.

__`/run` ->__ sistem açıldığından itibaren çalışan araçların üretmiş olduğu bilgiler.

__`/srv` ->__ server(hizmetler)'in çeşitli dosyalarının bulunduğu yer.

__`/sys` ->__ sistem üzerindeki sürücüler ve modüller ile ilgili bilgilerin bulunduğu dizin.

__`/usr` ->__ sistem içinde çalıştırılabilir dosyaları ve bu dosyaların info'larını barındıran geniş çaplı bir dizin.

__`/var` ->__ sürekli değişen dosyaların bulunduğu dizin. (örn: .log dosyaları)

__`/dev/null` ->__ trash can gibi ama içine girdiğimiz verileri hiçliğe gönderiyor.


# Redirects(?)

__`>` ->__ default olarak 1 yani stdout'tur. override işlemi yapar.

__`>>` ->__ default olarak 1 yani stdout'tur. append işlemi yapar.

__`2>` ->__  2 yani stderr'dir.

__`<` ->__ default olarak 0 yani stdin'dir.

__`2&>` ->__ 1 ve 2 yani stdout&stderr'dir. Burada 2 stream'ini 1'e yönlendiriyor.
