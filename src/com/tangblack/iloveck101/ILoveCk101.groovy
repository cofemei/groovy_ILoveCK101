package com.tangblack.iloveck101

//import os
//import sys
//import re
//import platform
//
//import gevent
//from gevent import monkey
//import requests
//from lxml import etree
//from more_itertools import chunked
//
//from .utils import get_image_info, parse_url
//from .exceptions import URLParseError
//
//
//monkey.patch_all()
//
//REQUEST_HEADERS = {'User-agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36'}
//BASE_URL = 'http://ck101.com/'
//CHUNK_SIZE = 3
//
//
//def iloveck101(url):
//	"""
//    Determine the url is valid. And check if the url contains any thread link or it's a thread.
//    """
//
//	if 'ck101.com' in url:
//		if 'thread' in url:
//			retrieve_thread(url)
//		else:
//			for thread in retrieve_thread_list(url):
//				if thread is not None:
//					retrieve_thread(thread)
//	else:
//		sys.exit('This is not ck101 url')
//
//
//def retrieve_thread_list(url):
//	"""
//    The url may contains many thread links. We parse them out.
//    """
//
//	resp = requests.get(url, headers=REQUEST_HEADERS)
//
//	# parse html
//	html = etree.HTML(resp.content)
//
//	links = html.xpath('//a/@href')
//	for link in links:
//		yield link
//
//
//def retrieve_thread(url):
//	"""
//    download images from given ck101 URL
//    """
//
//	# check if the url has http prefix
//	if not url.startswith('http'):
//		url = BASE_URL + url
//
//	# find thread id
//	m = re.match('thread-(\d+)-.*', url.rsplit('/', 1)[1])
//	if not m:
//		return
//
//	print '\nVisit %s' % (url)
//
//	thread_id = m.group(1)
//
//
//	# create `iloveck101` folder in ~/Pictures
//	system = platform.system()
//	if system == 'Darwin':
//		picfolder = 'Pictures'
//	else:
//		picfolder = ''
//
//	home = os.path.expanduser("~")
//	base_folder = os.path.join(home, picfolder, 'iloveck101')
//
//	if not os.path.exists(base_folder):
//		os.mkdir(base_folder)
//
//	# parse title and images
//	try:
//		title, image_urls = parse_url(url)
//	except URLParseError:
//		sys.exit('Oops, can not fetch the page')
//
//	# create target folder for saving images
//	folder = os.path.join(base_folder, "%s - %s" % (thread_id, title))
//	if not os.path.exists(folder):
//		os.mkdir(folder)
//
//	def process_image_worker(image_url):
//		filename = image_url.rsplit('/', 1)[1]
//
//		# ignore useless image
//		if not image_url.startswith('http'):
//			return
//
//		# fetch image
//		print 'Fetching %s ...' % image_url
//		resp = requests.get(image_url, headers=REQUEST_HEADERS)
//
//		# ignore small images
//		content_type, width, height = get_image_info(resp.content)
//		if width < 400 or height < 400:
//			print "image is too small"
//			return
//
//		# save image
//		with open(os.path.join(folder, filename), 'wb+') as f:
//			f.write(resp.content)
//
//	for chunked_image_urls in chunked(image_urls, CHUNK_SIZE):
//		jobs = [gevent.spawn(process_image_worker, image_url)
//				for image_url in chunked_image_urls]
//		gevent.joinall(jobs)
//
//
//def main():
//	try:
//		url = sys.argv[1]
//	except IndexError:
//		sys.exit('Please provide URL from ck101')
//
//	iloveck101(url)

/**
 * Determine the url is valid. And check if the url contains any thread link or it's a thread.
 * 
 * @param url
 */
private void iLoveCk101(url)
{
	println "iLoveCk101 url=$url"
	
	if ((url =~ 'ck101.com') == false)
	{
		println "This is not ck101 url"
		return
	}
	
	if ((url =~ 'thread'))
	{
		retriveThread(url)
	}
	else
	{
		
	}
	
	//
	//def iloveck101(url):
	//	"""
//    Determine the url is valid. And check if the url contains any thread link or it's a thread.
//    """
	//
	//	if 'ck101.com' in url:
	//		if 'thread' in url:
	//			retrieve_thread(url)
	//		else:
	//			for thread in retrieve_thread_list(url):
	//				if thread is not None:
	//					retrieve_thread(thread)
	//	else:
	//		sys.exit('This is not ck101 url')
}

private void retriveThread(url)
{
	println "retriveThread url=$url"
}

/**
 * The url may contains many thread links. We parse them out.
 * 
 * @param url
 */
private void retriveThreadList(url)
{
	println "retriveThreadList url=$url"
}

/**
 * Main.
 */
static main(args)
{	
	if (args)
	{
		String url = args[0]
		assert url == "http://ck101.com/thread-2876990-1-1.html"
		iLoveCk101(url)
	}
	else
	{
		println "Please provide URL from ck101"
	}
}