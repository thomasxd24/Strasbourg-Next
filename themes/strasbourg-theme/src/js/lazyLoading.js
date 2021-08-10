function onReady(fn) {
    if (document.readyState != 'loading') {
        fn();
    } else {
        document.addEventListener('DOMContentLoaded', fn);
    }
}

function initLazyLoading() {
    
    const backgroundPreloader = {
        isBackgroundImage(element) {
            return element.hasAttribute('data-background-src')
        },
        observeWith(observer) {
            document.querySelectorAll("div[data-background-src]").forEach(element => observer.observe(element))
        },
        preload(element) { 
            const imageSrc = element.getAttribute('data-background-src')
            const backgroundImageStyle = `background-image: url(${imageSrc})`
            const existingStyles = element.hasAttribute('style') ? `${element.getAttribute('style')};` : '' 
       
            element.style = `${existingStyles}${backgroundImageStyle}`
        },
    }
    
    const imagePreloader = {
        isImage(element) {
            return element.hasAttribute('data-src')
        },
        observeWith(observer) {
            document.querySelectorAll("img[data-src]").forEach(element => observer.observe(element))
        },
        preload(element) {
            const imageSrc = element.getAttribute('data-src')
            element.setAttribute('src', imageSrc)
        },
    }
   
    const preload = (element) => {
        if(imagePreloader.isImage(element)) {
            imagePreloader.preload(element)
            return
        }

        if(backgroundPreloader.isBackgroundImage(element)) {
            backgroundPreloader.preload(element)
            return
        }
    }

    const observer = new IntersectionObserver((entries, self) => {
       entries
            .filter(entry => entry.isIntersecting)
            .forEach(entry => {
                preload(entry.target)
                self.unobserve(entry.target);
            }) 
    }, {
        rootMargin: '0px 0px 512px 0px',
        threshold: 0,
    })

    imagePreloader.observeWith(observer)
    backgroundPreloader.observeWith(observer)
}

onReady(() => {
    initLazyLoading()
})
